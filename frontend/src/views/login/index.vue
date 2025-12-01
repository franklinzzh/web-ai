<script setup>
import { onMounted, ref } from 'vue'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import { loginApi } from '@/api/login'
import { generateUrlApi } from '@/api/file'
import { ca } from 'element-plus/es/locales.mjs'

let loginForm = ref({username:'', password:''})
let router = useRouter()

// const backPathUrl = ref('')
// const isBgLoaded = ref(false)

// fetch background image URL
// const fetchBackground = async () => {
//   const res = await generateUrlApi({path: 'util/img--20251130_175949.png', expire: 10})
//   try {
//     if (res.code === 200) {
//       const url = res.data
//       // Preload image BEFORE showing background
//       const img = new Image()
//       img.src = url
//       img.onload = () => {
//         backPathUrl.value = url
//         isBgLoaded.value = true   // triggers fade-in
//       }
//       console.log('Background image URL fetched:', backPathUrl.value)
//     } else {
//       console.log(res.message)
//     }
//   } catch (error) {
//     console.error('Error fetching background image URL:', error)
//   }
// }
//登录
const login = async () => {
  console.log('Login form data:', loginForm.value)
  const res = await loginApi(loginForm.value)
  if (res.code === 200) {// 登录成功
    ElMessage.success('登录成功')
    localStorage.setItem('loginUser', JSON.stringify(res.data))
    router.push('/')// 跳转
  }else {
    console.log(res.message)
    ElMessage.error(res.message)
  }
}

//取消
const clear = () => {
  loginForm.value = {
    username: '',
    password: ''
  }
}

// onMounted(() => {
//   fetchBackground()
// })
</script>

<template>
  <!-- :class="{ 'bg-loaded': isBgLoaded }"
       :style="{backgroundImage: backPathUrl ? `url(${backPathUrl})` : 'none'}" -->
  <div id="container"
  :style="{
    backgroundImage: `url(/antVSluka.png)`
  }">
    <div class="login-form">
      
      <el-form label-width="80px">
        <p class="title">NBA Manager sign in</p>
        <el-form-item label="Account ID" prop="username">
          <el-input v-model="loginForm.username" placeholder="Enter username"></el-input>
        </el-form-item>

        <el-form-item label="Password" prop="password">
          <el-input type="password" v-model="loginForm.password"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button class="button" type="primary" @click="login">Sign in</el-button>
          <el-button class="button" type="info" @click="clear">Cancel</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<style scoped>
#container {
  min-height: 100vh;          /* full screen height */
  width: 100%;
  display: flex;
  justify-content: center;    /* center horizontally */
  align-items: center;        /* center vertically */
  background-repeat: no-repeat;
  background-size: cover;     /* full cover background */
  background-position: center;
  position: relative;
  /* opacity: 0;
  transition: opacity 1s ease; */
}

/* #container.bg-loaded {
  opacity: 1;
} */

.login-form {
  max-width: 400px;
  padding: 30px;
  margin: 0 auto;
  border: 1px solid #e0e0e0;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  background-color: white;
}

.title {
  font-size: 30px;
  font-family: '楷体';
  text-align: center;
  margin-bottom: 30px;
  font-weight: bold;
}

.button {
  margin-top: 30px;
  width: 120px;
}
</style>