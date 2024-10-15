<template>
  <v-form ref="formConsultarEstatus" v-model="valid" lazy-validation>
    <v-container fluid>
      <v-row justify="center">
        <v-col cols="12" md="8">
          <v-card class="elevation-12">
            <v-card-title class="title text-center"> Consultar Estatus de Cuenta </v-card-title>
            <v-card-text>
              <v-row>
                <v-col cols="12" md="6" class="pa-2">
                  <v-text-field
                    label="Número de cuenta"
                    v-model="numeroCuenta"
                    :rules="[rules.required]"
                    required
                  />
                </v-col>
              </v-row>

              <v-row>
                <v-col cols="12" class="pa-2 text-center">
                  <v-btn color="primary" @click="consultarEstatus">
                    <v-icon left>mdi-magnify</v-icon>
                    Consultar Estatus
                  </v-btn>
                </v-col>
              </v-row>

              <v-row v-if="mensajeEstatus">
                <v-col cols="12" class="pa-2">
                  <v-alert :type="tipoAlerta" dismissible>
                    {{ mensajeEstatus }}
                  </v-alert>
                </v-col>
              </v-row>

              <v-row justify="center">
                <v-col cols="4" class="text-center">
                  <BotonSalir />
                </v-col>
              </v-row>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script setup>
import { ref } from 'vue'
import BotonSalir from '@/components/Botones/BotonSalir.vue'

// Estados de validación y datos
const valid = ref(false)
const numeroCuenta = ref('')
const mensajeEstatus = ref('')
const tipoAlerta = ref('')

// Reglas de validación
const rules = {
  required: (value) => !!value || 'Campo requerido'
}
</script>

<style scoped>
.v-container {
  background: linear-gradient(to bottom right, #b9ece8, #43e4a1);
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
}

.v-card {
  margin: 20px;
  background-color: #ffffff;
  border-radius: 12px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.title {
  font-size: 2rem;
  font-weight: bold;
  color: #2c3e50;
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
}

.pa-2 {
  padding: 16px;
}

.text-center {
  text-align: center;
}

.v-btn {
  margin: 10px 0;
  background-color: #43e4a1;
  color: #ffffff;
  font-weight: bold;
}

.v-btn:hover {
  background-color: #36c98e;
}
</style>
