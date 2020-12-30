<template>
     <div class="nav">
        
    <v-app-bar
      color="#001522"
      flat
      dark
    > 
    <v-img 
        src="@/assets/covid.png"
        max-height="70"
        max-width="70"/>
      <v-toolbar-title><h3>COVID-19</h3></v-toolbar-title>

      <v-spacer></v-spacer>

      <v-menu
        left
        bottom
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            icon
            v-bind="attrs"
            v-on="on"
          >
            <v-icon>mdi-dots-vertical</v-icon>
          </v-btn>
        </template>

        <v-list>
          <v-list-item
            v-for="n in 2"
            :key="n"
            @click="() => {}"
          >
            <v-list-item-title>Option {{ n }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu> 

    </v-app-bar>
        
  </div>
</template>
<script>
export default {
    
}
</script>
<style scoped>

</style>