def call(String status) {

    def color = ''
    def message = ''

    if (status == 'STARTED') {
        color = 'warning'
        message = "⚠️ STARTED: ${env.JOB_NAME} #${env.BUILD_NUMBER}\n${env.BUILD_URL}"
    }
    else if (status == 'SUCCESS') {
        color = 'good'
        message = "✅ SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}\n${env.BUILD_URL}"
    }
    else if (status == 'FAILED') {
        color = 'danger'
        message = "❌ FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}\n${env.BUILD_URL}"
    }

    // 🔥 CRITICAL FIX (this was missing in your case)
    slackSend(
        channel: '#praveen-project',
        color: color,
        message: message,
        teamDomain: 'devops-wells',          // your Slack workspace
        tokenCredentialId: 'slack-cred'     // Jenkins credential ID
    )
}
