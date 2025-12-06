import request from '@/utils/request'

//fetch all departments
export const fetchAllApi = () => request.get('/depts')

//create a department
export const createtApi = (dept) => request.post('/depts', dept)

//fetch a department by id
export const fetchByIdApi = (id) => request.get(`/depts/${id}`)

//update a department
export const updateApi = (dept) => request.put('/depts', dept)

//delete a department by id
export const deleteByIdApi = (id) => request.delete(`/depts?id=${id}`)