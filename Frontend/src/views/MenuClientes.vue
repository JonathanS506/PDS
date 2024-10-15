<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <h1 class="title title-background">Funcionalidades para los clientes</h1>
      </v-col>
    </v-row>

    <v-row align="center" justify="space-between" class="button-row">
      <v-col cols="12" sm="5">
        <v-row align="center" justify="center">
          <v-icon large color="black">mdi-account-plus</v-icon>
        </v-row>
        <v-row align="center" justify="center">
          <BotonRegistrarClienteFisico />
        </v-row>
      </v-col>

      <v-col cols="12" sm="5">
        <v-row align="center" justify="center">
          <v-icon large color="black">mdi-domain-plus</v-icon>
        </v-row>
        <v-row align="center" justify="center">
          <BotonRegistrarClienteJuridico />
        </v-row>
      </v-col>
    </v-row>

    <v-row align="center" justify="space-between" class="button-row">
      <v-col cols="12" sm="5">
        <v-row align="center" justify="center">
          <v-icon large color="black">mdi-phone</v-icon>
        </v-row>
        <v-row align="center" justify="center">
          <BotonCambiarTelefono />
        </v-row>
      </v-col>

      <v-col cols="12" sm="5">
        <v-row align="center" justify="center">
          <v-icon large color="black">mdi-email</v-icon>
        </v-row>
        <v-row align="center" justify="center">
          <BotonCambiarCorreo />
        </v-row>
      </v-col>
    </v-row>

    <v-row align="center" justify="center" class="button-row">
      <v-col cols="12">
        <v-row align="center" justify="center">
          <v-icon large color="black">mdi-bank</v-icon>
        </v-row>
        <v-row align="center" justify="center">
          <BotonConsulCuentaConSuSaldo />
        </v-row>
      </v-col>
    </v-row>

    <v-row align="center" justify="center" class="button-row">
      <v-col cols="12">
        <v-row align="center" justify="center">
          <v-icon large color="black">mdi-logout</v-icon>
        </v-row>
        <v-row align="center" justify="center">
          <BotonSalir />
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import BotonSalir from '@/components/Botones/BotonSalir.vue'
import BotonRegistrarClienteFisico from '@/components/Botones/BotonPagrearClienteFisico.vue'
import BotonRegistrarClienteJuridico from '@/components/Botones/BotonPagCrearClienteJuridico.vue'
import BotonCambiarTelefono from '@/components/Botones/BotonCambiarTelefono.vue'
import BotonCambiarCorreo from '@/components/Botones/BotonCambiarCorreo.vue'
import BotonConsulCuentaConSuSaldo from '@/components/Botones/BotonConsulCuentaConSuSaldo.vue'
</script>

<style scoped>
.fill-height {
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  background: linear-gradient(135deg, #c2cee0, #2867cc);
}

.title {
  font-size: 2.5rem;
  font-weight: bold;
  color: #2c3e50;
  margin-bottom: 40px;
}

.title-background {
  background-color: #74b2e7;
  padding: 10px;
  border-radius: 5px;
}

.v-btn {
  width: 100%;
  max-width: 550px;
  font-size: 1.25rem;
  padding: 30px;
  white-space: normal;
  word-wrap: break-word;
  text-overflow: ellipsis;
  text-align: center;
}

.custom-btn:hover {
  transform: scale(1.05);
  background-color: #1e88e5;
}

.custom-btn:active {
  transform: scale(0.95);
  background-color: #1565c0;
}

.long-btn {
  max-width: 570px;
}

.v-icon {
  margin-bottom: 10px;
  color: #000000;
  font-size: 4rem;
}
</style>
