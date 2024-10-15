<template>
  <v-btn color="green darken-1" @click="registrarCliente">Registrar</v-btn>
</template>

<script setup>
import { defineProps, defineEmits } from 'vue'
import ClienteFisicoService from '../services/ClienteFisicoService'

const props = defineProps({
  cliente: {
    type: Object,
    required: true
  }
})

const emit = defineEmits(['registrar'])

const registrarCliente = async () => {
  try {
    await ClienteFisicoService.crearCliente(props.cliente)
    emit('registrar', 'Cliente físico registrado con éxito.')
  } catch (error) {
    const errorMsg = error.response
      ? error.response.data
      : 'Error de conexión. Por favor, intenta de nuevo.'
    emit('registrar', `Error al registrar el cliente: ${errorMsg}`)
  }
}
</script>

<style scoped></style>
