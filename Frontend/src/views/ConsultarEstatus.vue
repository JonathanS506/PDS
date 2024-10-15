<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <ConsultarEstatusFormulario />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import ConsultarEstatusFormulario from '@/components/ConsultarEstatusFormulario.vue'
</script>

<style scoped>
.fill-height {
  min-height: 100vh;
}
</style>
