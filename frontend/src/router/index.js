import Vue from 'vue'
import Router from 'vue-router'
import Register from '@/components/Register'
import Login from '@/components/Login'
import CustomerCrud from '@/components/CustomerCrud'

 
Vue.use(Router)
 
export default new Router({
  routes: [
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/customercrud',
      name: 'CustomerCrud',
      component: CustomerCrud
    }
  ]
})