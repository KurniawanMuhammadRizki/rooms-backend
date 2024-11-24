# Rooms API Documentation

## Overview
Rooms is a comprehensive property management and booking system API built with GraphQL. This API facilitates the management of properties, rooms, bookings, and user interactions for both property owners and guests.

## Tech Stack
This application is built using modern and robust technologies:
- **Backend Framework**: Spring Boot with Hibernate ORM for robust data persistence
- **API**: GraphQL for flexible and efficient data querying
- **Database**: PostgreSQL for reliable data storage
- **Caching**: Redis for high-performance caching and session management
- **Authentication**: JWT (JSON Web Token) for secure user authentication
- **Payment Gateway**: Midtrans integration for secure payment processing
- **Cloud Platform**: Deployed on Google Cloud Platform for scalability and reliability
- **Containerization**: Docker for consistent deployment and scalability
- **Testing**: Postman for API testing and documentation
- **Performance**: Optimized with Redis caching and efficient database queries

## Core Features
### 1. Property Management
- Property creation and management
- Facility management
- Room management with detailed configurations
- Peak season pricing
- Property categorization
- Multiple property pictures support

### 2. Booking System
- Room availability checking
- Booking management
- Price calculation with peak season consideration
- Transaction processing
- Payment integration (Manual transfer & Bank transfer)

### 3. User Management
- User registration (Tenant & Regular users)
- Authentication & Authorization
- Profile management
- Avatar upload

### 4. Reviews & Ratings
- Property reviews
- Rating system
- Reply management
- Review filtering and pagination

## Documentation Link
For detailed API documentation, visit our graphdoc Documentation: https://graphdoc.io/doc/gxhC2ME6y5x0lD4p/query 

## Authentication
All protected endpoints require JWT token authentication:
```graphql
# Header format
{
  "Authorization": "Bearer <your_jwt_token>"
}
