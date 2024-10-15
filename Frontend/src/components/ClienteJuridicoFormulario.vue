<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="12" md="10">
        <v-card class="elevation-12">
          <v-card-title class="title text-center"> Crear Cliente Jurídico </v-card-title>
          <v-card-text>
            <v-form ref="formClienteJuridico" v-model="valid" lazy-validation>
              <v-row>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Nombre del apoderado general"
                    v-model="clienteJuridico.nombrePila"
                    :rules="[rules.required]"
                    required
                  />
                </v-col>

                <v-col cols="12" md="6">
                  <v-text-field
                    label="Primer apellido"
                    v-model="clienteJuridico.primerApellido"
                    :rules="[rules.required]"
                    required
                  />
                </v-col>

                <v-col cols="12" md="6">
                  <v-text-field
                    label="Segundo apellido"
                    v-model="clienteJuridico.segundoApellido"
                    :rules="[rules.required]"
                  />
                </v-col>

                <v-col cols="12" md="6">
                  <v-text-field
                    label="Cédula Jurídica"
                    v-model="clienteJuridico.identificacion"
                    :rules="[rules.required, rules.validarCedulaJuridica]"
                    required
                  />
                </v-col>

                <v-col cols="12" md="6">
                  <v-text-field
                    label="Correo Electrónico"
                    v-model="clienteJuridico.correoElectronico"
                    :rules="[rules.required, rules.validarCorreo]"
                    required
                  />
                </v-col>

                <v-col cols="12" md="6">
                  <v-text-field
                    label="Número Telefónico"
                    v-model="clienteJuridico.telefono"
                    :rules="[rules.required, rules.validarTelefono]"
                    required
                  />
                </v-col>

                <v-col cols="12" md="6">
                  <v-text-field
                    label="Razón Social"
                    v-model="clienteJuridico.razonSocial"
                    :rules="[rules.required]"
                    required
                  />
                </v-col>

                <v-col cols="12" md="6">
                  <v-text-field
                    label="Tipo de Negocio"
                    v-model="clienteJuridico.tipoNegocio"
                    :rules="[rules.required]"
                    required
                  />
                </v-col>

                <v-col cols="12" md="6">
                  <v-text-field
                    label="Cantidad de cuentas"
                    v-model="clienteJuridico.cantidadCuentas"
                    type="number"
                    :rules="[rules.required, rules.validarCantidadCuentas]"
                    required
                  />
                </v-col>
              </v-row>

              <v-row class="mt-4" justify="center">
                <v-col cols="4" class="text-center">
                  <BotonAtras />
                </v-col>
                <v-col cols="4" class="text-center">
                  <v-btn color="green darken-1" @click="submitForm">Registrar</v-btn>
                </v-col>
                <v-col cols="4" class="text-center">
                  <BotonSalir />
                </v-col>
              </v-row>

              <v-row justify="center">
                <v-col cols="12" class="text-center">
                  <v-alert v-if="mensaje" type="success" dismissible>{{ mensaje }}</v-alert>
                </v-col>
              </v-row>
            </v-form>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { ref } from 'vue'
import BotonAtras from '@/components/Botones/BotonAtras.vue'
import BotonSalir from '@/components/Botones/BotonSalir.vue'
import axios from 'axios'

const valid = ref(false)
const clienteJuridico = ref({
  nombrePila: '',
  primerApellido: '',
  segundoApellido: '',
  identificacion: '',
  correoElectronico: '',
  telefono: '',
  razonSocial: '',
  tipoNegocio: '',
  cantidadCuentas: 1
})

const mensaje = ref('')
const rules = {
  required: (value) => !!value || 'Campo requerido',
  validarTelefono: (value) =>
    /^\d{8}$/.test(value) || 'El número de teléfono debe tener 8 dígitos.',
  validarCorreo: (value) =>
    /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}$/.test(value) ||
    'Correo electrónico inválido.',
  validarCedulaJuridica: (value) =>
    /^\d{10}$/.test(value) || 'La cédula jurídica debe tener 10 dígitos.',
  validarCantidadCuentas: (value) =>
    (Number.isInteger(Number(value)) && value >= 1 && value <= 10) ||
    'Debe ser un número entre 1 y 10.'
}

const submitForm = async () => {
  if (valid.value) {
    try {
      const response = await axios.post(
        'http://localhost:8080/api/clientes/juridico',
        clienteJuridico.value
      )
      mensaje.value = 'Cliente registrado exitosamente.'
      console.log('Cliente jurídico creado:', response.data)
      Object.keys(clienteJuridico.value).forEach((key) => {
        clienteJuridico.value[key] = ''
      })
    } catch (error) {
      console.error('Error al registrar cliente jurídico:', error.response?.data || error)
      mensaje.value = 'Error al registrar el cliente. Inténtalo de nuevo.'
    }
  }
}
</script>

<style scoped>
.v-container {
  background: linear-gradient(to bottom right, #b9ece8, #43e4a1);
  height: 100vh;
}

.v-card {
  margin: 20px;
  background-color: papayawhip;
  border-radius: 12px;
}

.title {
  font-size: 2.5rem;
  font-weight: bold;
  color: #2c3e50;
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
}

.v-row {
  margin-bottom: 20px;
}
</style>
