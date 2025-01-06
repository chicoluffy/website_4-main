<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/home">WSB Financial System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li v-for="item in menuItems" :key="item.text" class="nav-item">
          <a class="nav-link" aria-current="page" :href="item.link">
          <i :class="item.icon"></i> {{ item.text }}
        </a>
        </li>
      </ul>
        <LogoutBtn/>
    </div>
  </div>
</nav>
</template>
<script>
import LogoutBtn from './LogoutBtn.vue';

  export default{
    name: 'NavBarComponent',
    components:{
      LogoutBtn,
    },
    props:{
      isDarkMode:{
        type: Boolean,
        required: true
      },
    },
    data(){
      return{
        menuItems:[
          {text: 'Deposit', link: '/home/DepWithPage',icon:'fas fa-user',permission:'V2_EXECUTE_DEPOSIT'},
          {text: 'Withdrawals', link: '/home/WithdrawPage',icon:'fas fa-user',permission:'V2_EXECUTE_DEPOSIT'},
          {text: 'Automatic Withdrawals', link: '/home/AutomaticDepositPage',icon:'fas fa-user',permission:'V2_EXECUTE_DEPOSIT'},
          //{text: 'Customer Reports', link: '/',icon:'fa-solid fa-users-viewfinder'},
          {text: 'User Roll', link: '/home/rollPage',icon:'fa-solid fa-users-viewfinder',permission: 'V2_EXECUTE_TRANSACTION'},
          {text: 'Single Deposits', link: '/home/singleDeposit',icon:'fa-solid fa-money-bill-transfer',permission:'V2_EXECUTE_TRANSACTION_CREDIT'},
          {text: 'Import CSV', link: '/home/CSV',icon:'fa-solid fa-money-bill-transfer',permission:'V2_EXECUTE_TRANSACTION_DEBIT'},
        ],
        privileges: [],
      }
    },
    computed:{
      filteredMenuItems(){
        return this.menuItems.filter(item => this.hasPermission(item.permission));
      }
    },
    methods:{
      hasPermission(permission){
        return this.privileges.includes('V2_FINANCE_ADMIN') || this.privileges.includes(permission);  
      },
    },
    mounted(){
      const privileges = localStorage.getItem('privileges');
      if(privileges){
        this.privileges = JSON.parse(privileges);
      }
    }
   
  }
</script>