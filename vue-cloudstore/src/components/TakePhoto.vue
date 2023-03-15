<template>
    <div>
        <video ref="video">Stream Unavailable</video>
    </div>
</template>

<script>
export default {
    data(){
        return {
            video: null
        }
    },

    mounted() {
        this.video = this.$refs.video
        this.startCapture()
    },

    methods: {
        startCapture() {
            navigator.mediaDevices.getUserMedia({video: true, audio: false}).then(stream => {
                this.video.srcObject = stream
                this.video.play()
            })
        }
    }
}
</script>
