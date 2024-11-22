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
                    {text: 'Home', link: '/home',icon:'fas fa-home'},
                    {text: 'Profile', link: '/profile',icon:'fas fa-user'},
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