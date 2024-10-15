<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="12" md="10">
        <v-card class="elevation-12">
          <v-card-title class="title text-center">Eliminar Cuenta</v-card-title>
          <v-card-text>
            <v-form ref="formEliminarCuenta" v-model="valid" lazy-validation>
              <v-row>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Número de Cuenta"
                    v-model="numeroCuenta"
                    :rules="[rules.required]"
                    required
                  />
                </v-col>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="PIN de la Cuenta"
                    v-model="pin"
                    :rules="[rules.required]"
                    required
                    type="password"
                  />
                </v-col>
              </v-row>

              <v-row>
                <v-col cols="4" class="text-center">
                  <BotonAtras />
                </v-col>
                <v-col cols="4" class="text-center">
                  <v-btn color="red" @click="eliminarCuenta">
                    <v-icon left>mdi-delete</v-icon>
                    Eliminar Cuenta
                  </v-btn>
                </v-col>
                <v-col cols="4" class="text-center">
                  <BotonSalir />
                </v-col>
              </v-row>

              <v-row v-if="cuenta">
                <v-col cols="12" class="pa-2">
                  <v-alert type="warning">
                    {{ mensajeConfirmacion }}
                    <v-btn color="green" @click="confirmarEliminacion">Sí, eliminar cuenta</v-btn>
                    <v-btn color="grey" @click="cancelarEliminacion">No, cancelar</v-btn>
                  </v-alert>
                </v-col>
              </v-row>

              <v-row v-if="mensajeError">
                <v-col cols="12" class="pa-2">
                  <v-alert type="error">
                    {{ mensajeError }}
                  </v-alert>
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

const valid = ref(false)
const numeroCuenta = ref('')
const pin = ref('')
const mensajeError = ref('')
const cuenta = ref(null)
const mensajeConfirmacion = ref('')

const rules = {
  required: (value) => !!value || 'Campo requerido'
}

const eliminarCuenta = () => {
  // Lógica para eliminar la cuenta
}

const confirmarEliminacion = () => {
  // Lógica para confirmar la eliminación
}

const cancelarEliminacion = () => {
  cuenta.value = null
  mensajeConfirmacion.value = ''
}
</script>

<style scoped>
.v-container {
  background: linear-gradient(to bottom right, #b9ece8, #43e4a1);
  height: 100vh;
}

.v-card {
  margin: 20px;
  background-color: #f9f9f9;
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

.text-center {
  text-align: center;
}

.v-btn {
  margin: 10px 0;
}
</style>
