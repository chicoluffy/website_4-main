<template>
    <div :class="['main-Layout',{'dark-mode':isDarkMode}]">
        <NavBar :isDarkMode="isDarkMode"/>
        <div class="main-content">
            <SidebarComponent :isDarkMode="isDarkMode"/>
            <div class="content">
                <router-view :isDarkMode="isDarkMode"/>
            </div>
        </div>
    </div>
</template>
<script>
import NavBar from '@/components/NavBar.vue';
import EventBus from '@/eventBus/eventBus';
import SidebarComponent from '@/components/Sidebar.vue';
export default {
    name: 'MainLayout',
    components: {
        NavBar,
        SidebarComponent,
    },
    data() {
        return {
            isDarkMode: localStorage.getItem('dark-mode') === 'true' || (window.matchMedia('(prefers-color-scheme: dark)').matches),
        };
    },
    mounted() {
        EventBus.on('toggle-dark-mode', (isDarkMode) => {
            this.isDarkMode = isDarkMode;
        });
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
  flex: 1;
}

.sidebar {
  width: 200px;
  transition: background-color 0.3s;
}

.content {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

</style>