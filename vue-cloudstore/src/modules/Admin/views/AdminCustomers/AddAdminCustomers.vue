<template>
  <div class="page-log-in">
    <div class="columns">
      <div class="column is-4 is-offset-4">
        <h1 class="title">Add New Customer</h1>

        <form @submit.prevent="submitForm">
          <div class="field">
            <label>User Email</label>
            <div class="control">
              <input type="text" class="input" v-model="email" />
            </div>
          </div>

          <div class="field">
            <label>User Full Name</label>
            <div class="control">
              <input type="text" class="input" v-model="fullName" />
            </div>
          </div>

          <div class="field">
            <label>User Role</label>
            <div class="control">
              <input type="text" class="input" v-model="role" />
            </div>
          </div>

          <div class="field">
            <label>User Password</label>
            <div class="control">
              <input type="text" class="input" v-model="password" />
            </div>
          </div>

          <!-- <div class="field">
            <label>User House Name</label>
            <div class="control">
              <input type="text" class="input" v-model="houseName" />
            </div>
          </div>

          <div class="field">
            <label>User Residing Street</label>
            <div class="control">
              <input type="text" class="input" v-model="streetName" />
            </div>
          </div>

          <div class="field">
            <label>User Residing City</label>
            <div class="control">
              <input type="text" class="input" v-model="cityName" />
            </div>
          </div>

          <div class="field">
            <label>User Residing State</label>
            <div class="control">
              <input type="text" class="input" v-model="stateName" />
            </div>
          </div> -->

          <div class="notification is-danger" v-if="errors.length">
            <p v-for="error in errors" v-bind:key="error">{{ error }}</p>
          </div>

          <div class="field">
            <div class="control">
              <button class="button is-dark">Submit</button>
            </div>
          </div>

          <hr />
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "AddCustomerDetails",
  data() {
    return {
      email: "",
      fullName: "",
      role: "",
      password: "",
      errors: [],
    };
  },
  mounted() {},
  methods: {
    async submitForm() {
      const formData = {
        email: this.email,
        fullName: this.fullName,
        role: this.role,
        password: this.password
      };

      await axios
        .post("/user/register", formData)
        .then((response) => {
          toast({
            message: "New Customer successfully added",
            type: "is-success",
            dismissible: true,
            pauseOnHover: true,
            duration: 2000,
            position: "bottom-right",
          });

          //   const toPath = this.$route.query.to || "/cart";

          //   this.$router.push(toPath);
        })
        .catch((error) => {
          if (error.response) {
            for (const property in error.response.data) {
              this.errors.push(`${property}: ${error.response.data[property]}`);
            }
          } else {
            this.errors.push("Something went wrong. Please try again");

            console.log(JSON.stringify(error));
          }
        });
    },
  },
};
</script>