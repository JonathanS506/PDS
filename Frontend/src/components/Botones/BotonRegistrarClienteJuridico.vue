<template>
  <v-btn color="blue darken-1" @click="registrarCliente">Registrar Cliente Jurídico</v-btn>
</template>

<script setup>
import { defineProps } from 'vue'
import ClienteJuridicoService from '../services/ClienteJuridicoService'

const props = defineProps({
  cliente: {
    type: Object,
    required: true
  }
})

const registrarCliente = async () => {
  try {
    await ClienteJuridicoService.crearCliente(props.cliente)
    alert('Cliente jurídico registrado con éxito.')
  } catch (error) {
    alert(`Error al registrar el cliente: ${error}`)
  }
}
</script>

<style scoped></style>
