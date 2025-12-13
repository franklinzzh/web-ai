import { createRouter, createWebHistory} from 'vue-router';

import IndexView from '@/views/index/index.vue';
import ClazzView from '@/views/clazz/index.vue';
import StuView from '@/views/stu/index.vue';
import DeptView from '@/views/dept/index.vue';
import EmpView from '@/views/emp/index.vue';
import EmpReportView from '@/views/report/emp/index.vue';
import StuReportView from '@/views/report/stu/index.vue';
import LogView from '@/views/log/index.vue';

import LoginView from '@/views/login/index.vue';

import UserProfileView from '@/views/user/userProfile/index.vue';

import LayoutView from '@/views/layout/index.vue'

import NotFoundView from '@/views/notfoundpage/not-found-view.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
     path: '/', 
     name: '',
     component: LayoutView,
     redirect: '/index', //重定向
    //  dashboard
     children: [
      // guest allowed 
      {path: 'index', name: 'index', component: IndexView },
      // auth required
      {path: 'clazz', name: 'clazz', component: ClazzView },
      {path: 'stu', name: 'stu', component: StuView},
      {path: 'dept', name: 'dept', component: DeptView},
      {path: 'emp', name: 'emp', component: EmpView},
      {path: 'log', name: 'log', component: LogView },
      {path: 'empReport', name: 'empReport', component: EmpReportView },
      {path: 'stuReport', name: 'stuReport', component: StuReportView },
     ]
    },
    // login page
    {path: '/login', name: 'login', component: LoginView  },
    // user profile
    {path: '/user/:username', name: 'userProfile', component: UserProfileView  },

    // Catch-all route
    { path: '/:pathMatch(.*)*', name: 'notFound', component: NotFoundView, redirect: '/index' }
  ]
})

// const router = createRouter({
//   history: createWebHistory(import.meta.env.BASE_URL),
//   routes: [
//     {
//      path: '/', 
//      name: '',
//      component: LayoutView,
//      redirect: '/index', //重定向
//     //  dashboard
//      children: [
//       // guest allowed 
//       {path: 'index', name: 'index', component: IndexView, meta: { requiresAuth: false } },
//       // auth required
//       {path: 'clazz', name: 'clazz', component: ClazzView, meta: { requiresAuth: true } },
//       {path: 'stu', name: 'stu', component: StuView, meta: { requiresAuth: true }},
//       {path: 'dept', name: 'dept', component: DeptView, meta: { requiresAuth: true }},
//       {path: 'emp', name: 'emp', component: EmpView, meta: { requiresAuth: true }},
//       {path: 'log', name: 'log', component: LogView, meta: { requiresAuth: true }},
//       {path: 'empReport', name: 'empReport', component: EmpReportView, meta: { requiresAuth: true }},
//       {path: 'stuReport', name: 'stuReport', component: StuReportView, meta: { requiresAuth: true }},
//      ]
//     },
//     // login page
//     {path: '/login', name: 'login', component: LoginView, meta: { requiresAuth: false } },
//     // user profile
//     {path: '/user/:username', name: 'userProfile', component: UserProfileView, meta: { requiresAuth: true } }
//   ]
// })

// router.beforeEach((to, from, next) => {
//   console.log('router beforeEach invoked')
//   const loginUser = JSON.parse(localStorage.getItem('loginUser'))
//   // If route requires login
//   if (to.matched.some(record => record.meta.requiresAuth)) {
//     if (!loginUser) {
//       return next('/login') // no login → redirect
//     }
//   }
//   next() // allow
//   console.log('router beforeEach done')
// })


export default router;