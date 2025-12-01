<script setup>
import { ref, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus';
import { useRouter } from 'vue-router'

let router = useRouter()

const loginName = ref('')
const loginUserName = ref('')
//定义钩子函数, 获取登录用户名
onMounted(() => {
  //获取登录用户名
  let loginUser = JSON.parse(localStorage.getItem('loginUser'))
  loginName.value = loginUser ? loginUser.name : 'Guest [Sign in]'
  loginUserName.value = loginUser ? loginUser.username : null
})

const user = () => {
  let loginUser = JSON.parse(localStorage.getItem('loginUser'))
  if (loginUser) {
    ElMessage.info(`Direct to user: ${loginUserName.value}`);
    router.push({ name: 'userProfile', params: { username: loginUser.username } })
  } else {
    ElMessageBox.confirm('You are not logged in. Do you want to log in now?', 'Not Logged In', {
      confirmButtonText: 'Yes',
      cancelButtonText: 'No',
      type: 'warning',
    }).then(() => {
      router.push('/login')
    })
  }
}


const onLogout = () => {
  let loginUser = JSON.parse(localStorage.getItem('loginUser'))
  if (!loginUser) {
    ElMessage.info('You are not logged in');
    return
  } else {
    ElMessageBox.confirm('Are you sure you want to sign out?', 'Confirm Sign Out', {
      confirmButtonText: 'Yes',
      cancelButtonText: 'No',
      type: 'warning',
    }).then(() => {
      ElMessage.success('You have signed out successfully')
      localStorage.removeItem('loginUser')
      loginName.value = ''
      router.push('/login')
    })
  }
}

</script>


<template>
  <div class="common-layout">
  <el-container>
    <!-- Header 区域 -->
    <el-header class="header">
      <!-- Left title -->
      <div class="header-left">
        <span class="title">Admin Page</span>
      </div>

      <!-- Right tools -->
      <div class="header-right">
        <el-button text class="tool-item" @click="user">
          <el-icon><User /></el-icon>
          <span>{{ loginName }}</span>
        </el-button>
        <span class="divider">|</span>
        <el-button text bg class="tool-item" @click="onLogout">
          <el-icon><SwitchButton /></el-icon>
          <span>Sign out</span>
        </el-button>
      </div>
    </el-header>
    <el-container>

      <!-- left menu -->
      <el-aside width="200px" class="aside">
      <el-menu router>
        <!-- Index -->
        <el-menu-item index="/index">
          <el-icon><Promotion /></el-icon> 首页
        </el-menu-item>
        <!-- 班级管理菜单 -->
        <el-sub-menu index="/manage">
          <template #title>
            <el-icon><Menu /></el-icon> 班级学员管理
          </template>
          <el-menu-item index="/clazz">
            <el-icon><HomeFilled /></el-icon>班级管理
          </el-menu-item>
          <el-menu-item index="/stu">
            <el-icon><UserFilled /></el-icon>学员管理
          </el-menu-item>
        </el-sub-menu>
        <!-- 系统信息管理 -->
        <el-sub-menu index="/system">
          <template #title>
            <el-icon><Tools /></el-icon>系统信息管理
          </template>
          <el-menu-item index="/dept">
            <el-icon><HelpFilled /></el-icon>部门管理
          </el-menu-item>
          <el-menu-item index="/emp">
            <el-icon><Avatar /></el-icon>员工管理
          </el-menu-item>
        </el-sub-menu>

        <!-- 数据统计管理 -->
        <el-sub-menu index="/report">
          <template #title>
            <el-icon><Histogram /></el-icon>数据统计管理
          </template>
          <el-menu-item index="/empReport">
            <el-icon><InfoFilled /></el-icon>员工信息统计
          </el-menu-item>
          <el-menu-item index="/stuReport">
            <el-icon><Share /></el-icon>学员信息统计
          </el-menu-item>
          <el-menu-item index="/log">
            <el-icon><Document /></el-icon>日志信息统计
          </el-menu-item>
        </el-sub-menu>
      </el-menu>
      </el-aside>

      <el-container>
        <!-- main content -->
        <el-main>
          <router-view></router-view>
        </el-main>
        <el-footer>Footer</el-footer>
      </el-container>
    </el-container>

  </el-container>
  </div>
</template>


<style scoped>
/* header style */
.header {
  height: 60px;
  background: #ffffff;
  border-bottom: 1px solid #e6e6e6;
  display: flex;
  align-items: center;
  justify-content: space-between;   /* space between left and right */
  padding: 0 20px;
  box-sizing: border-box;
}

.title {
  font-size: 20px;
  font-weight: 600;
  color: #333;
}

.header-right {
  display: flex;
  align-items: center;
}

.tool-item {
  display: flex;
  align-items: center;
  color: #333;
  text-decoration: none;
  cursor: pointer;
  font-size: 15px;
}

.tool-item:hover {
  color: #409EFF;   /* Element Plus main color */
}

.tool-item span {
  margin-left: 6px;
}

.divider {
  margin: 0 18px;
  color: #bbb;
  font-size: 16px;
}

/* aside style */
.aside {
  display: flex;
  height: 100vh; /* 👈 Full screen height */
}


</style>
