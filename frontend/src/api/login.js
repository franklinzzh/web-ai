import request from '@/utils/request'

//login api
export const loginApi = (params) => request.post('/login', params)