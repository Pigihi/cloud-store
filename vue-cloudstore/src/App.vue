<template>
  <div id="wrapper">
    <nav class="navbar is-dark">
      <div class="navbar-brand">
        <router-link to="/" class="navbar-item" id="logoText"
          ><strong>Cloud Store</strong></router-link
        >

        <a
          class="navbar-burger"
          aria-label="menu"
          aria-expanded="false"
          data-target="navbar-menu"
          @click="showMobileMenu = !showMobileMenu"
        >
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
        </a>
      </div>

      <div
        class="navbar-menu"
        id="navbar-menu"
        v-bind:class="{ 'is-active': showMobileMenu }"
      >
        <div class="navbar-end mx-auto">
          <div class="navbar-item">
            <div class="select is-success">
              <select v-model="selectedCategory">
                <option selected>Category</option>
                <option
                  v-for="item in categories"
                  v-bind:key="item.id"
                  @click="getProductsByCategory(item)"
                >
                  {{ item.category }}
                </option>
              </select>
            </div>

            <form id="search-form" method="get" action="/search">
              <div class="field has-addons">
                <div class="control searchBox">
                  <input
                    id="search_text"
                    type="text"
                    class="input"
                    placeholder="What are you looking for?"
                    name="query"
                  />
                </div>

                <div class="control">
                  <button id="search_button" class="button is-success">
                    <span class="icon">
                      <i class="fa fa-search" aria-hidden="true"></i>
                    </span>
                    Search
                  </button>
                </div>
              </div>
            </form>

            <!-- <button class="button is-success" @click="toggleVoiceModal()">
              <span class="icon">
                <i class="fa fa-search" aria-hidden="true"></i>
              </span>
              Voice Search
            </button> -->
            <button class="js-modal-trigger button is-success" 
                    data-target="modal-js-example"
                    @click="openVoiceModal()"
            >
  Image Search
</button>

<button class="button is-success" 
        id="search-speech">
  Voice Search
</button>

          </div>
        </div>

        <div class="navbar-end ml-0">
          <!-- <router-link to="/summer" class="navbar-item">Summer</router-link>
          <router-link to="/winter" class="navbar-item">Winter</router-link> -->

          <div class="navbar-item">
            <div class="buttons">
              <template v-if="$store.state.isAuthenticated">
                <router-link
                  to="/admin"
                  class="button is-light"
                  v-if="$store.state.userRole == 'ADMIN'"
                  >My account</router-link
                >

                <router-link
                  class="button is-light"
                  v-if="$store.state.userRole == 'SHOP'"
                  to="/shop"
                  >My account</router-link
                >

                <router-link
                  class="button is-light"
                  v-if="$store.state.userRole == 'CUSTOMER'"
                  to="/customer"
                  >My account</router-link
                >

                <button
                  @click="logout()"
                  class="button is-danger"
                  id="logoutButton"
                >
                  Log out
                </button>
              </template>

              <template v-else>
                <router-link to="/login" class="button is-light"
                  >Log in</router-link
                >
                <router-link to="/signup" class="button is-light"
                  >Sign up</router-link
                >
              </template>

              <router-link
                to="/cart"
                class="button is-success"
                id="cartButton"
                v-if="
                  $store.state.userRole !== 'SHOP' &&
                  $store.state.userRole !== 'ADMIN'
                "
              >
                <span class="icon"><i class="fas fa-shopping-cart"></i></span>
                <span>Cart ({{ cartTotalLength }})</span>
              </router-link>

              <template v-if="$store.state.isAuthenticated">
                <div class="profile-dp-div">
                  <img
                    class="profile-dp"
                    src="http://www.thegurughantal.com/uploads/7/5/8/2/75825867/delhinightclubs-5-bwxyimsnzqm_orig.jpg"
                  />
                </div>
              </template>
            </div>
          </div>
        </div>
      </div>
    </nav>


    <!-- <div id="modal-js-example" class="modal">
  <div class="modal-background"></div>

  <div class="modal-content">
    <div class="box">
      <p>Modal JS example</p> -->
      <!-- Your content -->
    <!-- </div>
  </div>

  <button class="modal-close is-large" aria-label="close"
    @click="closeVoiceModal()"
  ></button>
</div> -->


<div id="modal-js-example" class="modal">
  <div class="modal-background"></div>

  <div class="modal-content">
    <div class="box">
      <!-- <p>Image Search</p> -->
      <!-- Your content -->

      <div>
        <p class="title">Take Photo</p>
        <p>Use plain background</p>
        <div>
        <video ref="video" @canplay="initCanvas()">Stream Unavailable</video>
        <canvas ref="canvas" style="display:none"/>
    </div>
      
      <button class="button is-success" @click="takePhoto()">Capture</button>
      <br>
      </div>

      <div>

      </div>

      <!-- <div class="tile is-ancestor">

  <div class="tile is-parent">
    <div class="tile is-child box">
      <p class="title">Take Photo</p>
        <div>
        <video ref="video">Stream Unavailable</video>
        <canvas ref="canvas" style="display:none"/>
    </div>
      
      <button class="button is-success" @click="takePhoto()">Capture</button>
      </div>
  </div>

  <div class="tile is-parent">
    <div class="tile is-child box">
      <p class="title">Upload Photo</p>
        
        <div class="file has-name is-boxed" id="file-js-example">
  <label class="file-label">
    <input class="file-input" type="file" name="resume" @change="displayFileName()">
    <span class="file-cta">
      <span class="file-icon">
        <i class="fas fa-upload"></i>
      </span>
      <span class="file-label">
        Choose a file…
      </span>
    </span>
    <span class="file-name">
      No Image uploaded
    </span>
  </label>
</div>
      
      </div>
  </div>
</div> -->

    <!-- For showing the image -->
     <div>

       <img :src="takenPicture" />
     </div>

    <footer class="modal-card-foot">
      <button class="button is-success" @click="sendImage()">Image Search</button>
      <button class="button" @click="closeVoiceModal()">Cancel</button>
    </footer>

    </div>
    
  </div>

  <button class="modal-close is-large" aria-label="close" @click="closeVoiceModal()"></button>
</div>


    <div
      class="is-loading-bar has-text-centered"
      v-bind:class="{ 'is-loading': $store.state.isLoading }"
    >
      <div class="lds-dual-ring"></div>
    </div>


    <!-- I added 'style-section' class below in order to edit it's properties in other templates, if I want.
        But, when I changed the style properties, it reflects in every other page as well. That's a problem. -->
    <section class="section style-section">
      <router-view />
    </section>

    <footer class="footer">
      <p class="has-text-centered">CloudStore</p>
    </footer>
  </div>
</template>

<script>
import axios from "axios";

import TakePhoto from "@/components/TakePhoto.vue"

/* eslint-disable no-undef */
// import { computed, ref, onMounted, onUnmounted, watch } from 'vue'
// import { useGeolocation } from './useGeoLocation'

export default {
  data() {
    return {
      showMobileMenu: false,
      cart: {
        items: [],
      },
      userLoc: {
        city: "",
        region: "",
        country: "",
        latitude: "",
        longitude: "",
      },
      categories: [],
      selectedCategory: "Category",
    
    // ------------------ For taking photo -------------------
    video: null,
    canvas: null,
    takenPicture: null
    
    };
    
  },

  components: {
    TakePhoto
  },

  beforeCreate() {
    this.$store.commit("initializeStore");

    const token = this.$store.state.token;

    if (token) {
      axios.defaults.headers.common["Authorization"] = "Bearer " + token;
    } else {
      axios.defaults.headers.common["Authorization"] = "";
    }
  },
  mounted() {
    this.cart = this.$store.state.cart;
    // this.getGeolocationInformation();
    this.getCategories();

    (function(d, m){
        var kommunicateSettings = {"appId":"YOUR_APP_ID","popupWidget":true,"automaticChatOpenOnNavigation":true};
        var s = document.createElement("script"); s.type = "text/javascript"; s.async = true;
        s.src = "https://widget.kommunicate.io/v2/kommunicate.app";
        var h = document.getElementsByTagName("head")[0]; h.appendChild(s);
        window.kommunicate = m; m._globals = kommunicateSettings;
      })(document, window.kommunicate || {});
  
    this.startVoiceSearch();

    // this.addp5SpeechScript();



  },
  computed: {
    cartTotalLength() {
      let totalLength = 0;

      for (let i = 0; i < this.cart.items.length; i++) {
        totalLength += this.cart.items[i].quantity;
      }

      return totalLength;
    },
  },

  methods: {
    getCategories() {
      axios.get(`/user/shop/product/category`).then((response) => {
        console.log(response);
        this.categories = response.data;
      });
    },

    getProductsByCategory(item) {
      this.$router.push(`/category?category=${item.category}`);
    },

    logout() {
      axios.defaults.headers.common["Authorization"] = "";

      localStorage.removeItem("token");
      localStorage.removeItem("username");
      localStorage.removeItem("userid");

      this.$store.commit("removeToken");

      this.$store.commit("setUserRole", "");

      this.$router.push("/");
    },

    async getGeolocationInformation() {
      // const API_KEY = "ab5a99eb2c834bd5846f191401c2cfab";
      const API_KEY = "a081e277312e4671a6826d28a8496cb6";
      const API_URL =
        "https://ipgeolocation.abstractapi.com/v1/?api_key=" + API_KEY;
      const apiResponse = await fetch(API_URL);
      const data = await apiResponse.json();
      const { city, country, region, latitude, longitude } = data;
      this.city = city;
      this.region = region;
      this.country = country;
      this.latitude = latitude;
      this.longitude = longitude;
      console.log(data);
      console.log(
        "City: " +
          this.city +
          " Latitude: " +
          this.latitude +
          " Longitude: " +
          this.longitude
      );
    },

    // For opening and closing modals
  openModal($el) {
    $el.classList.add('is-active');
  },
  closeModal($el) {
    $el.classList.remove('is-active');
  },

  openVoiceModal(){
    const modal = document.querySelector(".modal");
    // openModal(modal)
    modal.classList.add('is-active');

    this.canvas = this.$refs.canvas

    this.video = this.$refs.video
    this.startCapture()

  },

  closeVoiceModal(){

    console.log(this.takenPicture)

    const modal1 = document.querySelector(".modal");
    modal1.classList.remove('is-active');

    this.video.srcObject.getTracks().forEach(function(track) {
      track.stop()
    })
  },


  startCapture() {
    navigator.mediaDevices.getUserMedia({video: true, autdio: false}).then(stream => {
      this.video.srcObject = stream
      this.video.play()
    })
  },

  takePhoto(){
    let context = this.canvas.getContext('2d')
    context.drawImage(this.video, 0, 0, this.video.videoWidth, this.video.videoHeight)
    this.takenPicture = this.canvas.toDataURL('image/jpeg')
  },

  initCanvas(){
    this.canvas.setAttribute('width', this.video.videoWidth)
    this.canvas.setAttribute('height', this.video.videoHeight)
  },

  displayFileName(){
    const fileInput = document.querySelector('#file-js-example input[type=file]');
    fileInput.onchange = () => { 
      if(fileInput.files.length > 0){
        const fileName = document.querySelector('#file-js-example .file-name');
        fileName.textContent = fileInput.files[0].name;
      }
    }
  },

  async sendImage(){
    await axios
      .post("http://localhost:5000/imageRecognition", this.takenPicture)
      .then((response) => {
        console.log(response.data)
        this.closeVoiceModal()
        var search_box = document.getElementById("search_text")
        var search_button = document.getElementById("search_button")
        search_box.value = response.data
        search_button.click()
      })
  },

  startVoiceSearch() {
    var voice = {
  // (A) INIT SPEECH RECOGNITION
  sform : null, // HTML SEARCH FORM
  sfield : null, // HTML SEARCH FIELD
  sbtn : null, // HTML VOICE SEARCH BUTTON
  recog : null, // SPEECH RECOGNITION OBJECT
  init : function () {
    // (A1) GET HTML ELEMENTS
    voice.sform = document.getElementById("search-form");
    voice.sfield = document.getElementById("search_text");
    voice.sbtn = document.getElementById("search-speech");
 
    // (A2) GET MICROPHONE ACCESS
    navigator.mediaDevices.getUserMedia({ audio: true })
    .then((stream) => {
      // (A3) SPEECH RECOGNITION OBJECT + SETTINGS
      const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
      voice.recog = new SpeechRecognition();
      voice.recog.lang = "en-US";
      voice.recog.continuous = false;
      voice.recog.interimResults = false;
 
      // (A4) POPUPLATE SEARCH FIELD ON SPEECH RECOGNITION
      voice.recog.onresult = (evt) => {
        let said = evt.results[0][0].transcript.toLowerCase();
        voice.sfield.value = said;
        // voice.sform.submit();
        // OR RUN AN AJAX/FETCH SEARCH
        voice.stop();
        
        var normalSearch = document.getElementById("search_button")
        normalSearch.click()
      };
 
      // (A5) ON SPEECH RECOGNITION ERROR
      voice.recog.onerror = (err) => { console.error(err); };
 
      // (A6) READY!
      voice.sbtn.disabled = false;
      voice.stop();
    })
    .catch((err) => {
      console.error(err);
      voice.sbtn.value = "Please enable access and attach microphone.";
    });
  },
 
  // (B) START SPEECH RECOGNITION
  start : () => {
    voice.recog.start();
    voice.sbtn.onclick = voice.stop;
    voice.sbtn.value = "Speak Now Or Click Again To Cancel";
  },
 
  // (C) STOP/CANCEL SPEECH RECOGNITION
  stop : () => {
    voice.recog.stop();
    voice.sbtn.onclick = voice.start;
    voice.sbtn.value = "Press To Speak";
  }
};
window.addEventListener("DOMContentLoaded", voice.init); 
  },

  addp5SpeechScript(){
    var speechScript = document.createElement("script"); speechScript.type = "text/javascript"; speechScript.async = true;
    speechScript.src = "https://cdn.jsdelivr.net/gh/IDMNYU/p5.js-speech@0.0.3/lib/p5.speech.js";
    var headTag = document.getElementsByTagName("head")[0]; headTag.appendChild(speechScript);
  }

  },
};
</script>

<style lang="scss">
@import "../node_modules/bulma";

.profile-dp {
  width: max-width;
  height: max-width;
  border-radius: 50%;
}

.lds-dual-ring {
  display: inline-block;
  width: 80px;
  height: 80px;
}
.lds-dual-ring:after {
  content: " ";
  display: block;
  width: 64px;
  height: 64px;
  margin: 8px;
  border-radius: 50%;
  border: 6px solid #ccc;
  border-color: #ccc transparent #ccc transparent;
  animation: lds-dual-ring 1.2s linear infinite;
}
@keyframes lds-dual-ring {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

.is-loading-bar {
  height: 0;
  overflow: hidden;

  -webkit-transition: all 0.3s;
  transition: all 0.3s;

  &.is-loading {
    height: 80px;
  }
}

.searchBox {
  width: 500px;
}
</style>
