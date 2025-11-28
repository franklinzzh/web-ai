import request from '@/utils/request'

//fetch employee list with params
export const fetchListApi = (params) => request.get('/emps', { params })

//create an employee
export const createApi = (emp) => request.post('/emps', emp)

//update an employee
export const updateApi = (emp) => request.put('/emps', emp)

//fetch an employee by id
export const fetchByIdApi = (id) => request.get(`/emps/${id}`)

//delete an employee by id
export const deleteByIdApi = (id) => request.delete(`/emps?id=${id}`)    