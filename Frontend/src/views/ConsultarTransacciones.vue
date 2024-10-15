<template>
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center">
        <v-col cols="12">
          <ConsultarTransaccionesFormulario />
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script setup>
  import ConsultarTransaccionesFormulario from '@/components/ConsultarTransaccionesFormulario.vue'
  </script>
  
  <style scoped>
  .fill-height {
    min-height: 100vh;
  }
  </style>
  