# Hospital-management-doc-patient-appointment-2

<img width="1220" height="750" alt="Screenshot 2026-06-10 152841" src="https://github.com/user-attachments/assets/210ad223-9337-490e-921b-18bc01dd16f4" />

Relationships
User ──────── OneToOne ──────── Doctor/Patient
Doctor ─────── OneToMany ─────── Appointment
Patient ─────── OneToMany ─────── Appointment
