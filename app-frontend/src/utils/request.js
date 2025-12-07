import axios from 'axios'
import { ElMessage } from 'element-plus'
import router from '../router'

// create axios object
const request = axios.create({
  baseURL: '/api', // matches your Vite proxy
  timeout: 5000
})

//axios的请求 request 拦截器, 每次请求获取localStorage中的loginUser, 从中获取到token, 在请求头token中携带到服务端
request.interceptors.request.use(
  (config) => {
    let loginUser = JSON.parse(localStorage.getItem('loginUser'))
    console.log(localStorage.getItem('loginUser'))
    if (loginUser) {
      config.headers.token = loginUser.token
    }
    return config
  }
)

let isShowing401Message = false;

//axios的响应 response 拦截器
request.interceptors.response.use(
  (response) => { //成功回调
    return response.data
  },
  (error) => { //失败回调
    if (error.response) {
      //如果响应的状态码为401, 则路由到登录页面
      if (error.response.status === 401 && !isShowing401Message) {
        isShowing401Message = true
        ElMessage.error('Sign in expired, please sign in again.')
        router.push('/login')
        setTimeout(() => isShowing401Message = false, 1000);
      }else{
        ElMessage.error('API request error.')
      }
    } else {
      ElMessage.error('Server not responding or network error.')
    }
    return Promise.reject(error)
  }
)

export default request
