<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <EliminarCuentaFormulario />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import EliminarCuentaFormulario from '@/components/EliminarCuentaFormulario.vue'
</script>

<style scoped>
.fill-height {
  min-height: 100vh;
}
</style>
