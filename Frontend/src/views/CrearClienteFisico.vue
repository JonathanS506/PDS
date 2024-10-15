<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <ClienteFisicoFormulario />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import ClienteFisicoFormulario from '@/components/ClienteFisicoFormulario.vue'
</script>

<style scoped>
.fill-height {
  min-height: 100vh;
  background: linear-gradient(to bottom right, #b9ece8, #43e4a1);
}
</style>
