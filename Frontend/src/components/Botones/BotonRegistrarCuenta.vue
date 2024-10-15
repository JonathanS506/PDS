<template>
  <v-btn color="purple darken-1" @click="registrarCuenta">Registrar Cuenta</v-btn>
</template>

<script setup>
import { defineProps } from 'vue'
import CuentaService from '@/services/CuentaService'

const props = defineProps({
  cuenta: {
    type: Object,
    required: true
  },
  idCliente: {
    type: String,
    required: true
  }
})

const registrarCuenta = async () => {
  try {
    await CuentaService.crearCuenta(props.cuenta, props.idCliente)
    alert('Cuenta registrada con éxito.')
  } catch (error) {
    alert(`Error al registrar la cuenta: ${error}`)
  }
}
</script>

<style scoped></style>
