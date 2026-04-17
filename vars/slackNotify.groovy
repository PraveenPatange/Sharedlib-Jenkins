def call(String status = 'STARTED') {

    // Ensure status is never null
    status = status ?: 'SUCCESS'

    def color = 'warning'   // ✅ default color
    def message = ''

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

    // ✅ Slack call (safe)
    slackSend(
        channel: '#praveen-project',
        color: color,
        message: message,
        teamDomain: 'devops-wells',
        tokenCredentialId: 'slack-token'
    )
}
