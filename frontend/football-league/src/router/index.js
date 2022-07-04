import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../components/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/team',
      name: 'team',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../components/team/Team.vue')
    },
    {
      path: '/teams',
      name: 'teams',
      component: () => import('../components/team/Teams.vue')
    },
    {
      path: '/standing',
      name: 'standing',
      component: () => import('../components/standings/Standing.vue')
    },
    {
      path: '/fixture',
      name: 'fixture',
      component: () => import('../components/fixture/Fixture.vue')
    }
  ]
})

export default router
