package com.mehmetboluk.spacexapp.service.model

import java.io.Serializable


data class LaunchModelItem(
    val crew: List<Any>,
    val details: String,
    val flight_number: Int,
    val is_tentative: Boolean,
    val last_date_update: String,
    val last_ll_launch_date: String,
    val last_ll_update: String,
    val last_wiki_launch_date: String,
    val last_wiki_revision: String,
    val last_wiki_update: String,
    val launch_date_local: String,
    val launch_date_source: String,
    val launch_date_unix: Int,
    val launch_date_utc: String,
    val launch_failure_details: LaunchFailureDetails,
    val launch_site: LaunchSite,
    val launch_success: Boolean,
    val launch_window: Int,
    val launch_year: String,
    val links: Links,
    val mission_id: List<Any>,
    val mission_name: String,
    val reuse: Reuse,
    val rocket: Rocket,
    val ships: List<String>,
    val static_fire_date_unix: Int,
    val static_fire_date_utc: String,
    val tbd: Boolean,
    val telemetry: Telemetry,
    val tentative_max_precision: String,
    val timeline: Timeline,
    val upcoming: Boolean
): Serializable