package ng.thenorthstar.goldenlist.features.jobs.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ng.thenorthstar.goldenlist.features.jobs.domain.model.JobListing


//Append Entity to show this is a db object
//Prepend Network to signify network data class

@Serializable
data class JobListingNetworkResponse(
    @SerialName("data")
    val `data`: List<Data?>?,
    @SerialName("links")
    val links: Links?,
    @SerialName("meta")
    val meta: Meta?
)

@Serializable
data class Data(
    @SerialName("company_name")
    val companyName: String?, // Rituals
    @SerialName("created_at")
    val createdAt: Int?, // 1666363982
    @SerialName("description")
    val description: String?, // <strong>Company Description</strong><br><br><strong>Job Description</strong><br><p><em>Tauche während der schönsten Zeit des Jahres in die wundervolle Welt von Rituals ein. Luxuriöse Home-und Körperprodukte, weihnachtliche Musik, zarte Düfte, herzliche Kollegen und die besten Kunden.</em></p><p>Werde jetzt ein Teil davon als Aushilfe auf 520€-Basis.&#xa0;</p><p><strong>SHARE YOUR TALENT.</strong></p><p>Als unsere Weihnachtsaushilfe bist du ein Allrounder-Talent und liebst es je nach Bedarf unterschiedliche Tätigkeiten zu meistern.&#xa0;</p><ul><li>Ob tolle Kundenberatung, wunderschöne Geschenke verpacken oder für Ordnung im Store und im Lager zu sorgen– wir finden die perfekte Aufgabe für dich&#xa0;</li><li>Als Brand Ambassador kreierst du weihnachtliche Glücksmomente, indem du z. B. unseren Kunden die Geschichten der Rituals Produkte erzählst, sie mit einem Lächeln im Gesicht berätst und sie zwischenzeitlich zu einem aromatischen Tee einlädst.</li></ul><p><strong>ENJOY OUR BENEFITS.&#xa0;</strong></p><p>Wir möchten, dass du dich wohlfühlst und bieten dir deshalb viele verschiedene Vorteile.</p><ul><li>Wertschätzung und Teamzusammenhalt</li><li>Zahlreiche Geschenke sowie ein hochwertiges Weihnachtsgeschenk</li><li>Exzellentes Onboarding</li><li>Rituals Mitarbeiterrabatt</li><li>Gratis Snacks &amp; Getränke im Shop</li><li>und noch viele weitere Vorteile</li></ul><p><strong>BE YOURSELF.</strong></p><p><strong>&#xa0;</strong>Bei uns zählt nicht nur dein Lebenslauf, sondern vor allem deine Persönlichkeit.</p><ul><li>Flexibilität hinsichtlich der zu übernehmenden Tätigkeiten und deiner zeitlichen Verfügbarkeiten</li><li>Authentische Persönlichkeit</li><li>Stark ausgeprägte Kommunikationsfähigkeit</li><li>Begeisterung für unsere Rituals Produkte</li></ul><p><strong>WE ARE RITUALS.</strong></p><p>Wir bei Rituals möchten mithilfe unserer einzigartigen Home &amp; Body Produkte und durch unsere Philosophie „The Art of Soulful Living“ sowohl Mitarbeiter als auch Kunden auf dem Weg zu persönlichem Wellbeing begleiten und dabei unterstützen, ihr wahres Potential zu wecken und die Schönheit des Lebens zu genießen.&#xa0;</p><p>WE LOVE DIVERSITY: Unsere Rituals Familie ist eine Repräsentation wundervoller Menschen mit unterschiedlichen Hintergründen, Identitäten und einzigartigen Eigenschaften und Fähigkeiten.&#xa0;</p><p><strong>&#xa0;</strong>Möchtest du Teil unseres unglaublichen Unternehmens werden und einen wesentlichen Beitrag für unsere innovative Marke leisten? Starte jetzt deine Karriere mit uns und folge auch unseren Karriereseiten auf&#xa0;<a href="http://www.linkedin.com/company/ritualscosmeticsdach">LinkedIn</a>&#xa0;&amp;&#xa0;<a href="http://www.xing.com/companies/ritualscosmeticsgermanygmbh">Xing</a>&#xa0;für exklusive Einblicke in die Welt von&#xa0;<a href="https://careers.rituals.com/de/de/unternehmen">Rituals</a>. Wir freuen uns auf dich!</p><p><strong>YOUR BODY. YOUR SOUL. YOUR RITUALS.</strong></p><p><em>Unabhängig von den Texten und Bildern in unseren Recruiting-Materialien betonen wir, dass bei Rituals alle Menschen gleichermaßen willkommen sind.</em></p><p>&#xa0;</p>
    @SerialName("job_types")
    val jobTypes: List<String?>?,
    @SerialName("location")
    val location: String?, // Freiburg im Breisgau
    @SerialName("remote")
    val remote: Boolean?, // false
    @SerialName("slug")
    val slug: String?, // weihnachtsaushilfe-freiburg-rituals-freiburg-im-breisgau-germany-161444
    @SerialName("tags")
    val tags: List<String?>?,
    @SerialName("title")
    val title: String?, // Weihnachtsaushilfe (m/w/d) - Freiburg
    @SerialName("url")
    val url: String? // https://www.arbeitnow.com/view/weihnachtsaushilfe-freiburg-rituals-freiburg-im-breisgau-germany-161444
)

@Serializable
data class Links(
    @SerialName("first")
    val first: String?, // https://www.arbeitnow.com/api/job-board-api?page=1
    @SerialName("last")
    val last: String?, // null
    @SerialName("next")
    val next: String?, // https://www.arbeitnow.com/api/job-board-api?page=2
    @SerialName("prev")
    val prev: String? // null
)

@Serializable
data class Meta(
    @SerialName("current_page")
    val currentPage: Int?, // 1
    @SerialName("from")
    val from: Int?, // 1
    @SerialName("info")
    val info: String?, // Jobs are updated every hour and order by the `created_at` timestamp. Use `?page=` to paginate. Read more information here: https://arbeitnow.com/blog/job-board-api
    @SerialName("path")
    val path: String?, // https://www.arbeitnow.com/api/job-board-api
    @SerialName("per_page")
    val perPage: Int?, // 100
    @SerialName("terms")
    val terms: String?, // This is a free public API for jobs, please do not abuse. I would appreciate linking back to the site. By using the API, you agree to the terms of service present on Arbeitnow.com
    @SerialName("to")
    val to: Int? // 100
)

fun Data.getJobListing(): JobListing {
    return JobListing(
        this.title ?: "",
        this.description ?: "",
        this.slug ?: "",
        this.companyName ?: "",
        this.location ?: "",
        this.createdAt.toString() ?: "",
        this.jobTypes?.joinToString() ?: "",
        isRemoteJob = this.remote ?: false,
        this.tags?.joinToString() ?: "",
        this.url ?: ""
    )
}