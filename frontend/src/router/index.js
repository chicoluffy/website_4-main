import {createRouter,createWebHistory} from 'vue-router';
import HomePage from '@/views/HomePage.vue';
import LoginPage from '@/views/LoginPage.vue';
import MainLayout from '@/Layouts/MainLayout.vue';
import UserView from '@/views/UserView.vue';
import DivisionPage from '@/views/DivisionPage.vue';
import CsvPage from '@/views/CsvPage.vue';
import SingleDeposit from '@/views/SingleDeposit.vue';
import RollBasePage from '@/views/RollBasePage.vue';
import DepWithPage from '@/views/DepWithPage.vue';
import WithdrawPage from '@/views/WithdrawPage.vue';
import AutomaticDepositPage from '@/views/AutomaticDepositPage.vue';

const routes = [
  { path: '/', name: 'LoginPage', component: LoginPage },
  {path: '/Division', name:'DivisionPage', component: DivisionPage,meta: { requiresAuth: true }},
  {
    path: '/home',
    component: MainLayout,
    children: [
        { path: '', name: 'HomePage', component: HomePage }, // Ruta base de MainLayout
        { path: 'user', name: 'UserView', component: UserView },
        {path: 'csv', name: 'CsvPage', component: CsvPage},
        {path: 'singleDeposit', name: 'SingleDeposit', component: SingleDeposit},
        {path: 'rollPage', name: 'RollBasePage', component: RollBasePage},
        {path: 'DepWithPage', name: 'DepWithPage', component: DepWithPage},
        {path: 'WithdrawPage', name: 'WithdrawPage', component: WithdrawPage},
        {path: 'AutomaticDepositPage',name: 'AutomaticDepositPage', component: AutomaticDepositPage}
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
    const token = localStorage.getItem('token');
    if(to.meta.requiresAuth && !token){
        next('/');
    }else{
        next();
    }
});
export default router;