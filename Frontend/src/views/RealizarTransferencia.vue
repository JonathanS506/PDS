<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <TransferenciaFormulario />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import TransferenciaFormulario from '@/components/TransferenciaFormulario.vue'
</script>

<style scoped>
.fill-height {
  min-height: 100vh;
  background: linear-gradient(to bottom right, #b9ece8, #43e4a1);
}
</style>
