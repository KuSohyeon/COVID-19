import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Korea from "@/views/Korea.vue";
import World from "@/views/World.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
    redirect: '/korea',
    children: [
      {
        path: 'korea',
        name: 'korea',
        component: Korea,
      },
      {
        path: 'world',
        name: 'world',
        component: World,
      },
    ],
  },

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
