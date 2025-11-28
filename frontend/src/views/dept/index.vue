<script setup>
import { ref, onMounted } from 'vue';
import { fetchAllApi, createtApi, fetchByIdApi, updateApi, deleteByIdApi } from '@/api/dept';
import { ElMessage, ElMessageBox } from 'element-plus';

onMounted(() => {
  search()
});

const search = async () => {
  try {
    const response = await fetchAllApi();
    console.log('Start fetchAllApi');
    console.log('Department data:', response.data);
    tableData.value = response.data;
  } catch (error) {
    console.error('Error fetching department data:', error);
  }
};  
const tableData = ref([]);

// dept dialog form data
const dialogFormVisible = ref(false);
const dept = ref({name: ''});
const formTitle = ref('');

const deptFormRef = ref();

// add dept
const addDept = () => {
  dialogFormVisible.value = true; // open dialog
  formTitle.value = 'Add Department';

  // clear previous validation messages
  if(deptFormRef.value) {
    deptFormRef.value.resetFields(); 
  }

  dept.value.name = ''; // reset form data
};

//create or update dept
  const save = async () => {
    if(!deptFormRef.value) return;
    // validate form input
    await deptFormRef.value.validate(async (valid) => {
      if(valid) {
        let result;
        if(dept.value.id) {
        // update existing dept
        result = await updateApi(dept.value);
      } else {
        // create new dept
        result = await createtApi(dept.value);
      }
      if (result.code == 200) {
        console.log('Department added successfully');
        //1. remind message
        ElMessage.success('Congrats, a department is added successfully!');
        //2. close dialog
        dialogFormVisible.value = false;
        //3. refresh table data
        search(); 
        } else {
        ElMessage.error(result.message);
      }
    } else {
      ElMessage.error('Form input is invalid')
    }
  });
  dialogFormVisible.value = false;
};

const edit = async (id) => {
  formTitle.value = 'Edit Department';
  // to be implemented
  const res = await fetchByIdApi(id);
  if(res.code == 200) {
    dialogFormVisible.value = true;
    dept.value = res.data;
    // clear previous validation messages
    if(deptFormRef.value) {
      deptFormRef.value.resetFields(); 
    }
  } else {
    ElMessage.error(res.message);
  } 
};

// delete dept
const deleteById = async (id) => {
  formTitle.value = 'Delete Department';
  ElMessageBox.confirm(
    'This department will be deleted. Continue?',
    'Warning',
    {confirmButtonText: 'OK', cancelButtonText: 'Cancel', type: 'warning',}
  ).then(async () => {
    try {
      const res = await deleteByIdApi(id);
      if(res.code == 200) {
        ElMessage.success('Department deleted successfully');
        search();
      } else {
        ElMessage.error(res.message);
      } 
    } catch (error) {
      console.error('API Error:', error);
      ElMessage.error('Network error, please try again later');
    }
  }).catch(() => {
    ElMessage.info('Delete canceled');
    return;
  })
  
};

// form data input validation rules
const rules = ref({
  name: [
    { required: true, message: 'Please input Department name', trigger: 'blur' },
    { min: 2, max: 10, message: 'Length should be 2 to 10', trigger: 'blur' },
  ],
});

</script>

<template>
  <h1>Department Management</h1>
  <div class="wrapper">
    <div class="container">
      <el-button type="primary" @click="addDept">+ Department</el-button>
    </div>
  </div>

  <div class="container">
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column type="index" label="No" width="100" align="center"/>
      <el-table-column prop="name" label="Dept name" width="180" align="center"/>
      <el-table-column prop="createTime" label="Create Time" width="250" align="center"/>
      <el-table-column prop="updateTime" label="Last Update Time" width="250" align="center"/>
      <el-table-column label="Actions" width="300" align="center">
        <template #default="scope">
          <el-button type="primary" size="small" @click="edit(scope.row.id)"><el-icon><Edit /></el-icon>Edit</el-button>
          <el-button type="danger" size="small" @click="deleteById(scope.row.id)"><el-icon><Delete /></el-icon>Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <!-- dialog with form -->
  <el-dialog v-model="dialogFormVisible" :title="formTitle" width="500">
    {{ dept }}
    <el-form :model="dept" :rules="rules" ref="deptFormRef">
      <el-form-item label="Dept name" label-width="'120px'" prop="name">
        <el-input v-model="dept.name"/>
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="save">Confirm</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<style scoped>
.wrapper {
  display: flex;
  justify-content: flex-end; /* move to right */
}

.container {
  padding: 10px;
  margin: 10px 0px;
}
</style>