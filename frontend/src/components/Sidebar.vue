<template>
   <div :class="['sidebar',{'dark-mode':isDarkMode}]">
    <ul>
        <li v-for="item in filteredMenuItems" :key="item.text">
            <RouterLink :to="item.link">
              <i :class="item.icon"></i>{{ item.text }}
            </RouterLink>
        </li>
    </ul>     
   </div>
</template>

<script>
    export default{
        name: 'SidebarComponent',
        props:{
            isDarkMode:{
                type: Boolean,
                required: true
            }
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
                privileges: []
            };
        },
        computed:{
          filteredMenuItems(){
              return this.menuItems.filter(item => this.hasPermission(item.permission));
          }
        },
        methods:{
          hasPermission(permission){
            return this.privileges.includes('V2_FINANCE_ADMIN') || this.privileges.includes(permission);  
          }
        },
        mounted(){
          const privileges = localStorage.getItem('privileges');
          if(privileges){
            this.privileges = JSON.parse(privileges);
          }
        }
    }
</script>

<style scoped>
.sidebar {
  width: 100%;
  height: 100vh;
  transition: background-color 0.3s;
}

.sidebar.dark-mode {
  background-color: #212E36;
  color: white;
}

.sidebar:not(.dark-mode) {
  background-color: #f4f4f4;
  color: black;
}
ul {
  width: 100%;
  list-style: none; /* Quitar el círculo */
  padding: 0;
  margin: 0;
}
li {
    padding: 0.9rem;
 /* Añadir espacio entre los ítems */
}

li a {
  color: inherit;
  text-decoration: none;
  display: flex;
  align-items: center;
}

.menu-icon {
  margin-right: 0.25rem; /* Ajustar este valor para separar más los iconos del texto */
}

.sidebar.dark-mode li a {
  color: #52A5E0;
  text-decoration: none;
}

.sidebar:not(.dark-mode) li a {
  color: #2A3B47;
    text-decoration: none;
}
</style>