def call(String status = 'STARTED') {

    def color = ''
    def message = ''

    // Default fallback
    status = status ?: 'SUCCESS'

    if (status == 'STARTED') {
        color = 'warning'
        message = "⚠️ STARTED: ${env.JOB_NAME} #${env.BUILD_NUMBER}\n${env.BUILD_URL}"
    }
    else if (status == 'SUCCESS') {
        color = 'good'
        message = "✅ SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}\n${env.BUILD_URL}"
    }
    else {
        color = 'danger'
        message = "❌ FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}\n${env.BUILD_URL}"
    }

    // ✅ Correct Slack call
    slackSend(
        channel: '#praveen-project',
        color: color,
        message: message,
        teamDomain: 'devops-wells',          // your Slack workspace
        tokenCredentialId: 'slack-token'     // Jenkins credential ID
    )
}
