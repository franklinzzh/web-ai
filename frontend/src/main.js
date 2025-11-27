import { createApp } from 'vue'
import App from './App.vue'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// Router
import router from './router'
// Icons
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

// Global CSS
// import './style.css'

const app = createApp(App)

// 1. install Element Plus
app.use(ElementPlus)

// 2. install Vue Router
app.use(router)

// 3. register icons globally
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

app.mount('#app')
