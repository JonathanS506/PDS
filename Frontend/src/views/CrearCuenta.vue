<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <CuentaFormulario @cuentaCreada="handleCuentaCreada" />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import CuentaFormulario from '@/components/CuentaFormulario.vue'

//Para maneajar la logica cuando se cree
const handleCuentaCreada = (cuenta) => {
  console.log('Cuenta creada:', cuenta)
}
</script>

<style scoped>
.fill-height {
  min-height: 100vh;
}
</style>
