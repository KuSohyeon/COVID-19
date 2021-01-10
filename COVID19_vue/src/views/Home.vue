<template>
  <v-container class="home text-center">
    
        <router-link to="/korea" class="text-decoration-none "><v-btn text class="white--text"><b>국내</b></v-btn></router-link>
        <router-link to="/world" class="text-decoration-none"><v-btn text class="white--text"><b>해외</b></v-btn></router-link>
    
        <router-view></router-view>
   
  </v-container>
</template>

<script>
// @ is an alias to /src


export default {
  name: "Home",
  components: {
    
  }
};
</script>
<style scoped>
.home{
  height: 100%;
}
</style>
