<script setup>
import { ref, reactive, watch, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { fetchListApi, createApi } from '@/api/emp'
import { fetchAllApi as fetchDeptsApi } from '@/api/dept'

//Job list
const jobs = ref([{ name: '班主任', value: 1 },{ name: '讲师', value: 2 },{ name: '学工主管', value: 3 },{ name: '教研主管', value: 4 },{ name: '咨询师', value: 5 },{ name: '其他', value: 6 }])
//Gender list
  const genders = ref([{ name: 'Male', value: 1 }, { name: 'Female', value: 2 }])
//Department list
const depts = ref([])

const jobMap = {1: "班主任", 2: "讲师", 3: "学工主管", 4: "教研主管", 5: "咨询师"}

const searchEmp = reactive({
  name: '',
  gender: '',
  dateRange: [],
  begin: '',
  end: ''
})
const empList = ref([])

// watch dateRange changes
watch(
  () => searchEmp.dateRange,
  (newValue) => {
    const [start, end] = newValue || []
    searchEmp.begin = start || ""
    searchEmp.end = end || ""
  }
)
// fetch department list for select options
const fetchDepts = async () => {
  try {
    const res = await fetchDeptsApi() 
    if (res.code === 200) {
      depts.value = res.data
      console.log('Department list:', depts.value)
    } else {
      console.error(res.message)
    }
  } catch (error) {
    console.error('Error fetching departments:', error)
  }
} 
// search employees
const search = async () => {
  try {
    const res = await fetchListApi({name: searchEmp.name,
      gender: searchEmp.gender,
      begin: searchEmp.begin,
      end: searchEmp.end,
      page: currentPage.value,
      pageSize: pageSize.value
    })
    empList.value = res.data.rows
    console.log('Employee list:', empList)
    total.value = res.data.total
    // console.log('Total employees:', total.value);
  } catch (error) {
    console.error('Error fetching employee data:', error)
  }
}

const clear = () => {
  // 清空表单
  searchEmp.name = ''
  searchEmp.gender = ''
  searchEmp.dateRange = []
  searchEmp.begin = ''
  searchEmp.end = ''
  search()
}

// pagination data
const currentPage = ref(1)
const pageSize = ref(10)
const total = ref(0)

// handle pagination changes
const handleSizeChange = (val) => {
  pageSize.value = val
  console.log(`page size: ${val}`)
  search()
}
const handleCurrentChange = (val) => {
  currentPage.value = val
  console.log(`current page: ${val}`)
  search()
}

const dialogVisible = ref(false)
//dialog for create/update employee
const dialogTitle = ref('')
const employee = ref({
  username: '',
  name: '',
  gender: '',
  phone: '',
  job: '',
  salary: '',
  deptId: '',
  entryDate: '',
  image: '',
  exprList: []
})

//File upload handlers
const beforeAvatarUpload = (rawFile) => {
  if (rawFile.type !== 'image/jpeg' && rawFile.type !== 'image/png') {
    ElMessage.error('Only JPG/PNG images are allowed')
    return false
  } else if (rawFile.size / 1024 / 1024 > 10) {
    ElMessage.error('Only images smaller than 10MB are allowed')
    return false
  }
  return true
}

const handleAvatarSuccess = (response,uploadFile) => {
  employee.value.image = response.data
  ElMessage.success('Avatar uploaded successfully')
}

const handleAvatarError = (err,uploadFile) => {
  console.error('Avatar upload failed:', err)
  ElMessage.error('Avatar upload failed')
} 

// check before close dialog
const handleClose = (done) => {
  ElMessageBox.confirm('Are you sure to close this dialog?')
    .then(() => {
      done()
    })
    .catch(() => {
    })
}

// add employee
const add = () => {
  console.log('Add employee clicked') 
  dialogVisible.value = true; // open dialog
  dialogTitle.value = 'Add Employee';
}

//工作经历
//动态添加工作经历 .
const addExprItem = () => {
  employee.value.exprList.push({exprDate: [], begin: '', end: '', company: '', job: ''})
}
//动态删除工作经历 .
const delExprItem = (index) => {
  employee.value.exprList.splice(index, 1)
}
//监听-employee员工对象中的工作经历数据
watch(()=>employee.value.exprList, (newValue, oldValue) => {
  if(employee.value.exprList && employee.value.exprList.length > 0) {
    employee.value.exprList.forEach(expr => {
      expr.begin = expr.exprDate[0]
      expr.end = expr.exprDate[1]
    })
  }
}, {deep: true});

onMounted(() => {
  // initiate the table
  search()
  // fetch department list
  fetchDepts()
})
</script>



<template>
  <h1>员工管理</h1> <br>

  <!-- emp search form -->
  {{ searchEmp }}
  <el-form :inline="true" :model="searchEmp" class="emp-form-inline">
    <el-form-item label="Name">
      <el-input v-model="searchEmp.name" placeholder="Employee name" clearable />
    </el-form-item>
    <el-form-item label="Gender">
      <el-select
        v-model="searchEmp.gender"
        placeholder="Gender"
        clearable
      >
        <el-option v-for="gender in genders" :key="gender.name" :label="gender.name" :value="gender.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="Entry Date">
      <el-date-picker
        v-model="searchEmp.dateRange"
        type="daterange"
        start-placeholder="Start date"
        end-placeholder="End date"
        range-separator="to"
        value-format="YYYY-MM-DD"
        clearable
      />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="search">Search</el-button>
    </el-form-item>
    <el-form-item>
      <el-button @click="clear">Clear</el-button> 
    </el-form-item>
  </el-form>

  <!-- emp table -->
  <div class="wrapper">
    <div class="container">
      <el-button type="primary" @click="add">Add Employees</el-button>
    </div>
    <div class="container">
      <el-button type="danger" @click="">Remove Employees</el-button>
    </div>
  </div>
  <div class="container">
    <el-table :data="empList" border style="width: 100%">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column prop="name" label="Name" width="150" align="center"/>
      <el-table-column prop="gender" label="Gender" align="center">
        <template #default="scope" >
          {{ scope.row.gender == 1 ? '男' : '女' }}
        </template>
      </el-table-column>
      <el-table-column label="Avatar" width="170" align="center">
        <template #default="scope" >
          <el-avatar :src="scope.row.image" @error="() => false" class="avatar">
            <el-icon style="font-size: 50px;"><Avatar /></el-icon>
          </el-avatar>
        </template>
      </el-table-column>
      <el-table-column prop="deptName" label="Department Name" width="170" align="center"></el-table-column>
      <el-table-column label="Position" width="120" align="center">
        <template #default="scope">
          {{ jobMap[scope.row.job] || "其他" }}
        </template>
      </el-table-column>
      <el-table-column prop="entryDate" label="Hire Date" width="180" align="center"></el-table-column>
      <el-table-column prop="updateTime" label="Last Modified Time" width="210" align="center"></el-table-column>
      <el-table-column label="Actions" width="300" align="center">
        <template #default="scope">
          <el-button type="primary" size="small" @click=""><el-icon><Edit /></el-icon>Edit</el-button>
          <el-button type="danger" size="small" @click=""><el-icon><Delete /></el-icon>Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <!-- pagination -->
  <div class="pagination-container">
    <el-pagination
      v-model:current-page="currentPage"
      v-model:page-size="pageSize"
      :page-sizes="[10, 20, 30, 40]"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
  </div>

  <!-- add form dialog -->
  <el-dialog v-model="dialogVisible" :title="dialogTitle" :before-close="handleClose">
    <el-form :model="employee" label-width="auto" style="max-width: 600px">
      <!-- 基本信息 -->
      <!-- 第一行 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="Username">
              <el-input v-model="employee.username" placeholder="请输入员工用户名，2-20个字"></el-input>
            </el-form-item>
          </el-col>
          
          <el-col :span="12">
            <el-form-item label="Name">
              <el-input v-model="employee.name" placeholder="请输入员工姓名，2-10个字"></el-input>
            </el-form-item>
        </el-col>
      </el-row>
      <!-- 第二行 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="Gender">
            <el-select v-model="employee.gender" placeholder="请选择性别" style="width: 100%;">
              <el-option v-for="gender in genders" :key="gender.name" :label="gender.name" :value="gender.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="手机号">
            <el-input v-model="employee.phone" placeholder="请输入员工手机号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <!-- Third line -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="职位">
            <el-select v-model="employee.job" placeholder="请选择职位" style="width: 100%;">
              <el-option v-for="job in jobs" :key="job.name" :label="job.name" :value="job.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="薪资">
            <el-input v-model="employee.salary" placeholder="请输入员工薪资"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <!-- Fourth line -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="所属部门">
            <el-select v-model="employee.deptId" placeholder="请选择部门" style="width: 100%;">
              <el-option v-for="dept in depts" :key="dept.name" :label="dept.name" :value="dept.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="入职日期">
            <el-date-picker v-model="employee.entryDate" type="date" style="width: 100%;" placeholder="选择日期" format="YYYY-MM-DD" value-format="YYYY-MM-DD"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <!-- 第五行 -->
      <el-row :gutter="20">
        <el-col :span="24">
          <el-form-item label="头像">
            <el-upload
              class="avatar-uploader"
              action="/api/upload"
              :show-file-list="false"
              :before-upload="beforeAvatarUpload"
              :on-success="handleAvatarSuccess"
              :on-error="handleAvatarError"
              >
              <img v-if="employee.image" :src="employee.image" class="avatar" />
              <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
            </el-upload>
          </el-form-item>
        </el-col>
      </el-row>
      <!-- 工作经历 -->
      <!-- 第六行 -->
      <el-row :gutter="10">
        <el-col :span="24">
          <el-form-item label="工作经历">
            <el-button type="success" size="small" @click="addExprItem">+ 添加工作经历</el-button>
          </el-form-item>
        </el-col>
      </el-row>
      <!-- 第七行 ...  工作经历 -->
      <el-row :gutter="3" v-for="(expr, index) in employee.exprList">
        <el-col :span="10">
          <el-form-item size="small" label="时间" label-width="80px">
            <el-date-picker type="daterange" v-model="expr.exprDate" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" format="YYYY-MM-DD" value-format="YYYY-MM-DD" ></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item size="small" label="公司" label-width="60px">
            <el-input placeholder="请输入公司名称" v-model="expr.company"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item size="small" label="职位" label-width="60px">
            <el-input placeholder="请输入职位" v-model="expr.job"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="2">
          <el-form-item size="small" label-width="0px">
            <el-button type="danger" @click="delExprItem(index)">删除</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <!-- 底部按钮 -->
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="">保存</el-button>
      </span>
    </template>
  </el-dialog>
</template>



<style>
.emp-form-inline .el-input {
  --el-input-width: 150px;
}

.emp-form-inline .el-select {
  --el-select-width: 150px;
}

.wrapper {
  display: flex;
  justify-content: flex-end; /* move to right */
}

.container {
  padding: 10px;
  margin: 10px 0px;
}

.avatar {
  width: 60px;
  height: 60px;
  border-radius: 30%;
  object-fit: cover;
}

.avatar-uploader .avatar {
  width: 120px;
  height: 120px;
  display: block;
}

/* avatar upload */
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
</style>