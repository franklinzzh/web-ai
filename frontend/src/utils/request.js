import axios from 'axios'

// create axios object
const request = axios.create({
  baseURL: '/api', // matches your Vite proxy
  timeout: 5000
})

//axios的响应 response 拦截器
request.interceptors.response.use(
  (response) => { //成功回调
    return response.data
  },
  (error) => { //失败回调
    return Promise.reject(error)
  }
)

export default request
