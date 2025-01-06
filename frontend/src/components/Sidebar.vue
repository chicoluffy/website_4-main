<template>
   <div :class="['sidebar',{'dark-mode':isDarkMode, 'is-open': isSidebarOpen }]">
      
   </div>
</template>

<script>
import EventBus from '@/eventBus/eventBus';
    export default{
        name: 'SidebarComponent',
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
                isSidebarOpen: false,
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
          },
        },
        mounted(){
          const privileges = localStorage.getItem('privileges');
          if(privileges){
            this.privileges = JSON.parse(privileges);
          }
          EventBus.on('toggle-sidebar', (isSidebarOpen) => {
            this.isSidebarOpen = isSidebarOpen;
          });
        }
    }
</script>

<style scoped>
.sidebar {
  width: 250px;
  height: 100%;
  background-color: #333;
  color: white;
  position: fixed;
  top: 0;
  left: 0;
  transform: translateX(-100%);
  transition: transform 0.3s ease;
}

.sidebar.is-open {
  transform: translateX(0);
}
.sidebar ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.sidebar li {
  margin: 0;
  padding: 15px 20px; /* Espaciado interno */
  border-bottom: 1px solid #333; /* Separador entre elementos */
}
.sidebar li a {
  text-decoration: none; /* Sin subrayado */
  color: #52a5e0; /* Color del texto */
  font-weight: bold;
  display: flex;
  align-items: center;
  gap: 10px; /* Espaciado entre ícono y texto */
}

.sidebar li a:hover {
  background-color: #1b2a30; /* Cambio de fondo al pasar el mouse */
  color: #fff; /* Texto blanco al resaltar */
}

.sidebar.dark-mode {
  background-color: #212E36;
  color: white;
}

.sidebar:not(.dark-mode) {
  background-color: #f4f4f4;
  color: black;
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
.toggle-button {
  display: none;
  position: fixed;
  top: 10px;
  left: 10px;
  background-color: #333;
  color: white;
  border: none;
  font-size: 24px;
  cursor: pointer;
  z-index: 1001;
}

/* estilos para pantallas pequeñas */
@media (max-width: 768px) {
  .sidebar {
    width: 200px; /* Sidebar más pequeño en dispositivos móviles */
  }
  .toggle-button {
    display: block;
  }
  
}
</style>