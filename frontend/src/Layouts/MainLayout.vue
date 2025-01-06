<template>
    <div :class="['main-Layout',{'dark-mode':isDarkMode}]">
      <NavBar/>
        <div class="main-content">
            <div class="content">
                <router-view :isDarkMode="isDarkMode"/>
            </div>
        </div>
    </div>
</template>
<script>
import EventBus from '@/eventBus/eventBus';
import NavBar from '@/components/NavBar.vue';
export default {
    name: 'MainLayout',
    components: {
        NavBar,
    },
    data() {
        return {
            isDarkMode: localStorage.getItem('dark-mode') === 'true' || (window.matchMedia('(prefers-color-scheme: dark)').matches),
            isSidebarOpen: false,
        };
    },
    mounted() {
        EventBus.on('toggle-dark-mode', (isDarkMode) => {
            this.isDarkMode = isDarkMode;
        });
    },
    methods: {
      toggleSidebar() {
          this.isSidebarOpen = !this.isSidebarOpen;
      },
    },
};
</script>
<style scoped>
.main-layout {
  display: flex;
  flex-direction: column;
  height: 100vh;
  transition: background-color 0.3s;
}

.main-layout.dark-mode {
  background-color: black;
  color: white;
}

.main-layout:not(.dark-mode) {
  background-color: white;
  color: black;
}

.main-content {
  display: flex;
}

.content {
  flex: 1;
  transition: margin-left 0.3s ease;
}
/*estilos para pantallas pequeñas*/
@media (max-width: 768px) {
  .content{
    margin-left: 0;
  }
}

</style>