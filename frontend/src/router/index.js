import {createRouter,createWebHistory} from 'vue-router';
import HomePage from '@/views/HomePage.vue';
import LoginPage from '@/views/LoginPage.vue';
import MainLayout from '@/Layouts/MainLayout.vue';
import UserView from '@/views/UserView.vue';

const routes = [
  { path: '/', name: 'LoginPage', component: LoginPage },
  {
    path: '/home',
    component: MainLayout,
    children: [
        { path: 'home', name: 'HomePage', component: HomePage },
      { path: 'user', name: 'UserView', component: UserView }
    ],
    meta: { requiresAuth: true }
  }
];

const router = createRouter({
    history : createWebHistory(),
    routes
});
//verify if user is authenticated
router.beforeEach((to, from, next) => {
    const isAuthenticated = localStorage.getItem('auth');
    if(to.meta.requiresAuth && !isAuthenticated){
        next('/');
    }else{
        next();
    }
});
export default router;