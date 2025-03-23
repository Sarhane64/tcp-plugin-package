# capacitor-socket-tcp

Socket communication tcp with capacitor

## Install

```bash
npm install capacitor-socket-tcp
npx cap sync
```

## API

<docgen-index>

* [`connect(...)`](#connect)
* [`send(...)`](#send)
* [`close()`](#close)
* [`addListener('dataReceived', ...)`](#addlistenerdatareceived-)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### connect(...)

```typescript
connect(options: { host: string; port: number; }) => Promise<void>
```

Établit une connexion avec un serveur TCP

| Param         | Type                                         | Description                           |
| ------------- | -------------------------------------------- | ------------------------------------- |
| **`options`** | <code>{ host: string; port: number; }</code> | Contient l'hôte et le port du serveur |

--------------------


### send(...)

```typescript
send(options: { message: string; }) => Promise<void>
```

Envoie un message au serveur

| Param         | Type                              | Description                   |
| ------------- | --------------------------------- | ----------------------------- |
| **`options`** | <code>{ message: string; }</code> | Contient le message à envoyer |

--------------------


### close()

```typescript
close() => Promise<void>
```

Ferme la connexion au serveur

--------------------


### addListener('dataReceived', ...)

```typescript
addListener(eventName: 'dataReceived', listenerFunc: (data: { message: string; }) => void) => Promise<PluginListenerHandle>
```

Événement déclenché lorsqu'un message est reçu

| Param              | Type                                                 |
| ------------------ | ---------------------------------------------------- |
| **`eventName`**    | <code>'dataReceived'</code>                          |
| **`listenerFunc`** | <code>(data: { message: string; }) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |

</docgen-api>
