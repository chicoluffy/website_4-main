<template>
  <div :class="['tabs-container',{'dark-mode': isDarkMode}]">
    <div class="tabs-header">
      <button
        v-for="tab in tabs"
        :key="tab.name"
        :class="['tab-button', { active: activeTab === tab.name }]"
        @click="activeTab = tab.name"
      >
        {{ tab.label }}
      </button>
    </div>
    <!-- Tabs Content -->
    <div class="tab-content">
      <!-- Renderizar el componente correspondiente al tab activo -->
      <component :is="getCurrentComponent()" />
    </div>
  </div>
</template>

<script>
export default {
  name: 'TabsComponent',
  props: {
    tabs: {
      type: Array,
      required: true
    },
    isDarkMode:{
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      activeTab: this.tabs[0].name || '',
    };
  },
  methods: {
    getCurrentComponent() {
      const currentTab = this.tabs.find((tab) => tab.name === this.activeTab);
      return currentTab ? currentTab.component : null;
    },
  }
};
</script>

<style scoped>
.tabs-container {
  font-family: Arial, sans-serif;
  width: 100%;
  height: 100vh;
  margin: 0 auto;
  border: 1px solid #ddd;
  border-radius: 8px;
  overflow: hidden;
  background-color: white; 
  color: #333;
}
.tabs-container.dark-mode{
  background-color: #2a3b47;
  color: #fff;
  border-color:  #333;
}

.tabs-header {
  display: flex;
  border-bottom: 1px solid #ddd;
  background-color: #f9f9f9;
}
.tabs-header.dark-mode{
  background-color: #2a3b47;
  border-bottom-color: #444;
}

.tab-button {
  flex: 1;
  padding: 10px 20px;
  background: none;
  border: none;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s;
}

.tab-button:hover {
  background-color: #e5e5e5;
}

.tab-button.dark-mode:hover{
  background-color: #333;
}
.tab-button.active {
  background-color: #007bff;
  color: white;
  font-weight: bold;
}
.tab-button.dark-mode.active{
  background-color: #007bff; 
  color: white;
}

.tabs-content {
  padding: 20px;
  background-color: white;
}
.tabs-content.dark-mode{
  background-color: #2a3b47;
  color: #fff;
}
</style>