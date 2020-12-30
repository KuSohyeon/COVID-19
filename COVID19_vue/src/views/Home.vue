<template>
  <v-container class="home">
    
      <p class="white--text">메인페이지.</p>
        <router-link to="/korea" class="text-decoration-none "><v-btn text class="white--text">국내</v-btn></router-link>
        <router-link to="/world" class="text-decoration-none"><v-btn text class="white--text">해외</v-btn></router-link>
    
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
