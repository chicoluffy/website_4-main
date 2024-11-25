<template>
   <div :class="['sidebar',{'dark-mode':isDarkMode}]">
    <ul>
        <li v-for="item in menuItems" :key="item.text">
            <a :href="item.link">
                <i :class="['menu-icon', item.icon]"></i>
                {{ item.text }}
            </a>
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
                    {text: 'User', link: '/home/user',icon:'fas fa-user'},
                    {text: 'Customer Reports', link: '/profile',icon:'fa-solid fa-users-viewfinder'},
                    {text: 'WHT', link: '/profile',icon:'fa-solid fa-square-poll-vertical'},
                    {text: 'Stats', link: '/profile',icon:'fa-solid fa-chart-simple'},
                    {text: 'Failed Deposits', link: '/profile',icon:'fa-regular fa-thumbs-down'},
                    {text: 'Search', link: '/profile',icon:'fa-solid fa-magnifying-glass'},
                    {text: 'Single Deposits', link: '/profile',icon:'fa-solid fa-money-bill-transfer'},
                ]
            };
        }
    }
</script>

<style scoped>
.sidebar {
  width: 200px;
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
  margin-right: 0.6rem; /* Ajustar este valor para separar más los iconos del texto */
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