# Azure Key Vault
## Requisito

Instalar Azure Client

https://learn.microsoft.com/en-us/cli/azure/install-azure-cli-windows?pivots=msi

## Key vaults

1. create  
  **Key vault name:** CoticKeyVault  
  Review + create  
	create
	
    - Access control(IAM)  
	    Add role assignment  
		  Key Vault Administrator  
		  **+ Select members:** select user of azure portal  
		  Review + assign  
		
    - Secrets  
	    Generate/import  
		  **Name:** mes  
		  **Secret value:** abril  

Vault URI: https://cotickeyvault.vault.azure.net/  


## Microsoft Entra ID

App registrations  
	**New Registration:** springbootapp  
		**AZURE_CLIENT_ID**  
		**Application (client) ID:** 8d093e24-4074-4a03-87cd-87fb8345143a  
		**AZURE_TENANT_ID**  
		**Directory (tenant) ID:** dfd08e74-2882-4cef-88f9-3b5e1f4c3e01  

  - Certificates & secrets  
    **Description:** clientsecret  
    **AZURE_CLIENT_SECRET**  
    **Value:** dSV8Q~ghQ-wVKLPghrOvyhvOEBlVV-D__dPzSa89  
  
## Key vaults
- Access control(IAM)
	Add role assignment  
		Key Vault Secrets User  
		**+ Select members:** springbootapp  
		Review + assign

