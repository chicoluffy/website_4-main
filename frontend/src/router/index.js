import {createRouter,createWebHistory} from 'vue-router';
import HomePage from '@/views/HomePage.vue';
import LoginPage from '@/views/LoginPage.vue';
import MainLayout from '@/Layouts/MainLayout.vue';
import UserView from '@/views/UserView.vue';
import DivisionPage from '@/views/DivisionPage.vue';
import CsvPage from '@/views/CsvPage.vue';

const routes = [
  { path: '/', name: 'LoginPage', component: LoginPage },
  {path: '/Division', name:'DivisionPage', component: DivisionPage,meta: { requiresAuth: true }},
  {
    path: '/home',
    component: MainLayout,
    children: [
        { path: '', name: 'HomePage', component: HomePage }, // Ruta base de MainLayout
        { path: 'user', name: 'UserView', component: UserView },
        {path: 'csv', name: 'CsvPage', component: CsvPage}
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