import request from '@/utils/request'

// generate presigned upload URL
export const generateUrlApi = (params) => request.post('/upload/presign', params)